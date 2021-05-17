(ns ui.codemirror.cm-events.mouse
  (:require
   [taoensso.timbre :refer-macros [debug debugf info infof error]]
   [ui.codemirror.fun :refer [dispatch]]))

(defn on-mousedown [{:keys [cm-opts cm id] :as context} sender evt]
  (info "on-mousedown segment-id: " id)
  (dispatch context [:cm/mouse-down id]))