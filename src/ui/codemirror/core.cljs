(ns ui.codemirror.core
  (:require
   [taoensso.timbre :refer-macros [debug debugf info infof warn error]]
   [reagent.core :as r]
   [reagent.dom :as rd]
   [re-frame.core :refer [dispatch]]
   ["codemirror" :as CodeMirror]
   ["codemirror/addon/edit/closebrackets"]
   ["codemirror/addon/edit/matchbrackets"]
   ["codemirror/addon/hint/show-hint"]
   ["codemirror/addon/runmode/runmode"]
   ["codemirror/addon/runmode/colorize"]
   ["codemirror/mode/clojure/clojure"]
   ["codemirror/mode/markdown/markdown"]
   ; [cljsjs.codemirror.mode.xml]
   ; [cljsjs.codemirror.mode.javascript]
   ; ["parinfer-codemirror"]
   ; [cljsjs.codemirror.mode.clojure-parinfer]
   ;["codemirror/keymap/vim"]
   [ui.codemirror.theme]
   [ui.codemirror.highlight]
   [ui.codemirror.cm-events.change :refer [editor-load-content on-change]]
   [ui.codemirror.cm-events.key :refer [on-key-down on-key-up]]
   [ui.codemirror.cm-events.mouse :refer [on-mousedown]]
   [ui.codemirror.options :refer [cm-default-opts cm-keybindings]]))

(defn configure-cm-globally!
  "Initialize CodeMirror globally"
  []
  (error "Configure Code Mirror globally")                  ;
  (let [cm-commands (.-commands CodeMirror)
        cm-keymap (.-keyMap CodeMirror)]
    (if cm-commands
      (aset cm-commands "doNothing" #())
      (error "could not set codemirror commands!"))
    (if cm-keymap
      (aset cm-keymap "gorilla" (clj->js cm-keybindings))
      (error "could not set codemirror keymap!"))
    nil))

(defn focus-cm!
  [cm]
  (when cm
    (.focus cm)))

(defn blur-cm!
  [cm]
  (when cm
    (let [input (.getInputField cm)]
      (.blur input))))

(defn focus-active [id {:keys [active? view-only] :as cm-opts} cm]
  (when (and active? (not view-only))
    (debugf "focusing cm %s .." id  "active:" active? "view-only: " view-only)
    (focus-cm! cm)))

(defn blur-inactive [id {:keys [active? view-only] :as cm-opts} cm]
  (when (or (not active?) view-only)
    (debugf "blurring cm %s" id  "active:" active? "view-only: " view-only)
    (blur-cm! cm)))

(defn destroy-editor [cm-a]
  (if @cm-a
    (do (.toTextArea @cm-a)
        (reset! cm-a nil))
    (warn "Could not kill CodeMirror instance")))

(defn codemirror-reagent
  "code-mirror editor"
  [id {:keys [get-data] :as fun} cm-opts]
  (let [opts  (merge
               cm-default-opts
               cm-opts
               {:readOnly (:view-only cm-opts)})
        ;_ (warn "opts: " opts)
        cm (atom nil)
        make-event-handler (fn [f]
                             (fn [s evt]
                               ;(info "cm event - evt: " evt " cm:" s)
                               (f {:id id
                                   :cm-opts opts
                                   :fun fun
                                   :cm @cm} s evt)))]
    (r/create-class
     {:component-did-mount
      (fn [this]
        (let [el (rd/dom-node this)
              opts-js (clj->js opts)
              ;_ (info "component-did-mount: cm")
              ;cm_ (CodeMirror. el opts-js)
              cm_ (.fromTextArea CodeMirror el opts-js)
              code (get-data id)]
          (reset! cm cm_)
          (.setValue cm_ code)

          ; theme - already set in cm constructor
          ;(.setOption inst "theme" (:theme opts))

          (.on cm_ "change" (make-event-handler on-change))
          (.on cm_ "keydown"  (make-event-handler on-key-down))
          (.on cm_ "keyup"   (make-event-handler on-key-up))
          (.on cm_ "mousedown" (make-event-handler on-mousedown))

          (blur-inactive id opts cm_)
          (focus-active id opts cm_)

          ;(when on-cm-init (on-cm-init inst))
          ))

      :component-will-unmount
      (fn [this]
        (debug "cm component-will-unmount")
        (destroy-editor cm))

      :component-did-update
      (fn [this old-argv]
        (let [[_ id fun opts] (r/argv this)]
          ;(info "component-did-update: current buffer: " eval-result9         
          (editor-load-content @cm (get-data id))
          (blur-inactive id opts @cm)
          (focus-active id opts @cm)
          ;
          ))

      :reagent-render
      (fn []
        (let [{:keys [readOnly]} opts]
          (if readOnly
            [:textarea {:read-only true}]
            [:textarea])))})))



