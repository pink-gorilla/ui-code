(ns ui.code.goldly.codemirror-atom
  (:require
   [taoensso.timbre :refer-macros [debug debugf info infof error]]
   [ui.code.goldly.codemirror-themed :refer [codemirror-themed]]))

(defn codemirror-atom-impl [cm-opt id a path]
  (let [get-data (fn [id]
                   (info "cm-text get id:" id)
                   (if path
                     (get-in @a path)
                     @a))
        save-data (fn [id text]
                    (info "cm-text save id:" id)
                    (if path
                      (swap! a assoc-in path text)
                      (reset! a text)))
        cm-events (fn [cm-evt]
                    (info "cm-text event " cm-evt))
        fun {:get-data get-data
             :save-data save-data
             :cm-events cm-events}]

    [codemirror-themed id fun cm-opt]))

(defn codemirror-atom [id a path]
  [codemirror-atom-impl {:active? true
                         :view-only false} id a path])

(defn codemirror-atom-viewonly [id a path]
  [codemirror-atom-impl {:active? false
                         :view-only true} id a path])
