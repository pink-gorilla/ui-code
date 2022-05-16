(ns ui.codemirror.unbound.options
  (:require
   [taoensso.timbre :refer-macros [debug debugf info infof warn error]]
   ["codemirror" :as CodeMirror]))

(def cm-default-opts
  {:lineNumbers true
   :firstLineNumber 1
   :lineWrapping true ;  false=scroll (horizontal), true=wrap 
   ; viewportMargin: Specifies the amount of lines that are rendered above and 
   ; below the part of the document that's currently scrolled into view. This 
   ; affects the amount of updates needed when scrolling, and the amount of 
   ; work that such an update does. You should usually leave it at its 
   ; default, 10. Can be set to Infinity to make sure the whole document is 
   ; always rendered, and thus the browser's text search works on it. This 
   ; will have bad effects on performance of big documents.
   ;:viewportMargin js/Infinity
   :matchBrackets true
   :autoCloseBrackets "()[]{}\"\""
   :showCursorWhenSelecting true
   :theme "mdn-like" ; "default" ; 
   :mode "clojure" ; "clojure-parinfer"
   ;:keyMap "default" ; "vim" 
   :keyMap "gorilla"
   :extraKeys #js {} ;"Shift-Enter" "newlineAndIndent"}
   :autofocus false ; true
   :readOnly false ;true
   })

(def cm-keybindings
  {:Shift-Enter      "doNothing"
   :Shift-Ctrl-Enter "doNothing"
   :Shift-Alt-Enter  "doNothing"
   :fallthrough      "default"})

#_(def cm-default-opts {:text/x-clojure  {:cm-opts (merge cm-default-opts-common
                                                          {:mode "clojure"})}
                        :text/x-markdown {:cm-opts (merge cm-default-opts-common
                                                          {:mode "text/x-markdown"})}})

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

; webly brings a css loader
; this css loader is essential for codemirror, because codemirror expects
; that the css theme is loaded before it gets rendered.
; the css loader takes care of that - also if the theme gets changed at runtime

(defonce needs-init (atom true))

(defn ensure-initialized []
  (when @needs-init
    (configure-cm-globally!)
    (reset! needs-init false))
  nil)