(ns ui.codemirror.cm-events.mouse
  (:require
   [taoensso.timbre :refer-macros [debug debugf info infof error]]
   [ui.codemirror.fun :refer [dispatch]]
   [ui.codemirror.api.position :refer [cursor-coords]]))

(defn on-mousedown [{:keys [cm-opts cm id] :as context} sender evt]
  (debug "on-mousedown segment-id: " id)
  (let [c (cursor-coords cm)]
    (dispatch context [:cm/mouse-down id c])))
