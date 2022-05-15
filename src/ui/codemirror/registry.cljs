(ns ui.codemirror.registry
  (:require
   [taoensso.timbre :refer-macros [debug debugf info infof warn error]]
   [reagent.core :as r]))

(defonce active-editor-atom
  (r/atom {}))

(defn get-editor [id]
  (get @active-editor-atom id))