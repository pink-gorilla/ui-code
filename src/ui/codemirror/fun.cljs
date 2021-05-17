(ns ui.codemirror.fun
  (:require
   [taoensso.timbre :refer-macros [debug debugf info infof warn error]]))

(defn dispatch [{:keys [cm id fun] :as context} cm-evt]
  (let [cm-events (:cm-events fun)]
    (if cm-events
      (cm-events cm-evt)
      (warn "codemirror :cm-events is not setup" cm-evt))))

(defn save-data [{:keys [cm id fun] :as context} text]
  (let [save-data (:save-data fun)]
    (if save-data
      (save-data id text)
      (warn "codemirror :save-data is not setup" id text))))
