(ns ui.codemirror.goldly.codemirror-text
  (:require
   [taoensso.timbre :refer-macros [debug debugf info infof error]]

   [ui.codemirror.goldly.codemirror-themed :refer [codemirror-themed]]))

(defn codemirror [id text-a]
  (let [cm-opt {}
        get-data (fn [_] ; id
                   @text-a)
        save-data (fn [_ text]
                    (info "cm-text save")
                    (reset! text-a text))
        cm-events (fn [cm-evt]
                    (info "cm-text event " cm-evt))
        fun {:get-data get-data
             :save-data save-data
             :cm-events cm-events}]

    [codemirror-themed id fun cm-opt]))