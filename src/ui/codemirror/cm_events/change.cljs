(ns ui.codemirror.cm-events.change
  (:require
   [taoensso.timbre :refer-macros [debugf info error]]
   [ui.codemirror.fun :refer [save-data]]))

(defn move-to-last-line [cm]
  (let [last-line (.lastLine cm)
        last-ch (count (.getLine cm last-line))]
    (.setCursor cm last-line last-ch)))

; load/save from/to buffer

(defn editor-load-content [editor content]
  (.setValue editor content)
      ;(move-to-last-line @cm)
  )

(defn on-change [{:keys [cm id] :as context} sender evt]
  (let [code (.getValue cm)]
    (debugf "saving cm text id: %s" id)
    (save-data context code)))

