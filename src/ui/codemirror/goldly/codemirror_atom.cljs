(ns ui.codemirror.goldly.codemirror-atom
  (:require
   [taoensso.timbre :refer-macros [debug debugf info infof error]]

   [ui.codemirror.goldly.codemirror-themed :refer [codemirror-themed]]))

(defn codemirror-atom [id a path]
  (let [cm-opt {}
        get-data (fn [_] ; id
                   (if path
                     (get-in @a path)
                     @a))
        save-data (fn [_ text]
                    (info "cm-text save")
                    (if path
                      (swap! a assoc-in path text)
                      (reset! a text)))
        cm-events (fn [cm-evt]
                    (info "cm-text event " cm-evt))
        fun {:get-data get-data
             :save-data save-data
             :cm-events cm-events}]

    [codemirror-themed id fun cm-opt]))