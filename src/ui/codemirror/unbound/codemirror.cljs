(ns ui.codemirror.unbound.codemirror
  (:require
   [taoensso.timbre :refer-macros [debug debugf info infof warn error]]
   [reagent.core :as r]
   [reagent.dom :as rd]
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
   [ui.codemirror.highlight]
   [ui.codemirror.unbound.options :refer [cm-default-opts ensure-initialized]]
   [ui.codemirror.unbound.theme]
   [ui.codemirror.registry :refer [active-editor-atom get-editor]]))

(defn create-editor [id el opts-js]
  (info "creating codemirror-js id: " id)
  (ensure-initialized)
  ;cm_ (CodeMirror. el opts-js)
  (let [cm (.fromTextArea CodeMirror el opts-js)]
    (swap! active-editor-atom assoc id cm)
    cm))

(defn destroy-editor [id]
  (info "destroying codemirror-js id: " id)
  (if-let [cm (get-editor id)]
    (do (.toTextArea cm)
        (swap! active-editor-atom dissoc id))
    (error "Could not kill CodeMirror instance id: " id)))

(defn codemirror-unbound
  [id cm-opts]
  (let [cm-opts (or cm-opts {})
        opts  (merge
               cm-default-opts
               cm-opts)
        ;_ (warn "opts: " opts)
        ]
    (r/create-class
     {:component-did-mount
      (fn [this]
        (let [el (rd/dom-node this)
              opts-js (clj->js opts)]
          (create-editor id el opts-js)))

      :component-will-unmount
      (fn [this]
        (debug "cm component-will-unmount")
        (warn "this: " this)
        (destroy-editor id))

      :component-did-update
      (fn [this old-argv]
        (let [[_ id opts] (r/argv this)]
          (info "component-did-update: id " id "opts: " opts)
          ;(when-let [cm (get-editor id)]
            ;(editor-load-content cm (get-data id))
            ;(blur-inactive id opts cm)
            ;(focus-active id opts cm)
          ;  )
          ;
          ))

      :reagent-render
      (fn []
        (let [{:keys [readOnly]} opts]
          (if readOnly
            [:textarea {:read-only true}]
            [:textarea])))})))



