(ns ui.codemirror.cm-events.change
  (:require
   [taoensso.timbre :refer-macros [debugf info error]]
   [ui.codemirror.api.position :refer [move-to-last-line]]
   [ui.codemirror.fun :refer [save-data]]))

; load/save from/to buffer

(defn editor-load-content [cm content]
  (.setValue cm content)
      ;(move-to-last-line @cm)
  )

(defn on-change [{:keys [cm id] :as context} sender evt]
  (let [code (.getValue cm)]
    (debugf "saving cm text id: %s" id)
    (save-data context code)))

