(ns ui.codemirror.theme
  (:require
   [re-frame.core :refer [subscribe]]
   [taoensso.timbre :as timbre :refer [debug info warn error]]))

;; styles for theme

(defn style-codemirror-inline []
  ; Set height, width, borders, and global font properties here
  ; height: 200px;
  ; height: auto;    auto = adjust height to fit content 
  ; height: 100%
  [:style ".my-codemirror > .CodeMirror { 
              font-family: monospace;
              height: auto;
            }"])

(defn style-codemirror-fullscreen []
  ; height: auto; "400px" "100%"  height: auto;
  [:style ".my-codemirror > .CodeMirror { 
              font-family: monospace;
              height: 100% ;
            }"])

#_(defn styles-codemirror-for-setttings [layout]
    [:div
     (if (= layout :single)
       style-codemirror-fullscreen
       style-codemirror-inline)])

