(ns ui.codemirror.cm-js.arrow-nav
  (:require
   [taoensso.timbre :refer-macros [debug debugf]]
   [ui.codemirror.fun :refer [dispatch]]))

; navigate buffer up/down


(defn first-line-number [cm]
  (.firstLine cm))

(defn last-line-number [cm]
  (.lastLine cm))

(defn current-line-number [cm]
  (let [pos (.getCursor cm)]
    (.-line pos)))

(defn first-line? [cm]
  (let [f (first-line-number cm)
        c (current-line-number cm)]
    (debugf "first-line: %s current-line: " f c)
    (= f c)))

(defn last-line? [cm]
  (let [l (last-line-number cm)
        c (current-line-number cm)]
    (debugf "last-line: %s current-line: %s" l c)
    (= l c)))

(defn arrow-up [{:keys [cm id fun] :as context} e]
  (debugf "arrow-up context: %s" context)
  (when (first-line? cm)
    (debug "up on first-line!")
    (.preventDefault e)
    (dispatch context [:cm/move id :up])))

(defn arrow-down [{:keys [cm id fun] :as context} e]
  (debugf "arrow-down context: %s" context)
  (when (last-line? cm)
    (debug "down on last-line!")
    (.preventDefault e)
    (dispatch context [:cm/move id :down])))

