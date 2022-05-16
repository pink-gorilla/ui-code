(ns ui.codemirror.registry
  (:require
   [reagent.core :as r]))

(defonce active-editor-atom
  (r/atom {}))

(defn get-editor [id]
  (get @active-editor-atom id))