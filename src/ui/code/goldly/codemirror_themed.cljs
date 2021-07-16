(ns ui.code.goldly.codemirror-themed
  (:require
   [re-frame.core :as rf]
   [taoensso.timbre :refer-macros [debug debugf info infof errorf]]
   [ui.codemirror.core :refer [configure-cm-globally! codemirror-reagent]]))

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

(defn codemirror-themed [id fun cm-opt]
  (ensure-initialized)
  (let [theme (rf/subscribe [:css/theme-component :codemirror])]
    (fn [id fun cm-opt]
      (let [theme (or @theme "mdn-like") ;"(or (:codemirror-theme @settings) "paraiso-dark")
            cm-opt-themed (merge cm-opt {:theme theme})]
        [:div.my-codemirror
         [codemirror-reagent id fun cm-opt-themed]]))))

(defn codemirror-themed2 [id fun cm-opt]
  (debugf "cm id: %s fun: %s opt: %s" id fun cm-opt)
  [codemirror-themed id fun cm-opt])


