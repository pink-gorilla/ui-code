(ns ui.codemirror.cm-events.key
  (:require
   [taoensso.timbre :refer-macros [debug debugf info infof error]]
   [ui.codemirror.cm-js.line :refer [first-line? last-line?]]
   [ui.codemirror.cm-js.completion :refer [hint]]
   [ui.codemirror.fun :refer [dispatch]]))

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


;; http://gcctech.org/csc/javascript/javascript_keycodes.htm


(comment
  (def tab           9)
  (def enter        13)
  (def escape       27)

  (def arrow-left   37)
  (def arrow-up 	  38)
  (def arrow-right  39)
  (def arrow-down   40)

  (def shift 	      16)
  (def ctrl 	      17)
  (def alt 	        18)
  (def pause-break  19)
  (def caps-lock 	  20)
  (def window-left  91)
  (def window-right 92)
  (def select       93))

(defn on-key-up [{:keys [cm-opts cm] :as context} _ evt]
  (debug "key-up:" (.-keyCode evt)))

(defn on-key-down [{:keys [cm-opts cm] :as context} _ evt]
  (debugf "key-down: %s cm: %s" (.-keyCode evt) cm)
  (case (.-keyCode evt)

    #_enter #_(when (and (not (.-shiftKey evt))
                         (.-metaKey evt))
                (when-let [source (.getValue cm)]
                  (when (should-eval cm evt source)
                    (.preventDefault evt)
                    (run-eval source))))

    38 ; arrow-up
    (arrow-up context evt)

    40 ; arrow-down
    (arrow-down context evt)

    9 ; tab
    (when (not (.-shiftKey evt))
      (hint context evt))

    ;13 ; enter
    ;(rf/dispatch [:codemirror/completion-apply context evt])

    :none))

