(ns ui.codemirror.api
  (:require 
    [ui.codemirror.api.position]
    [ui.codemirror.api.code]
    [ui.codemirror.api.modal]
   )
  
  )

(def set-code ui.codemirror.api.code/set-code)
(def get-code ui.codemirror.api.code/get-code)

(def blur ui.codemirror.api.modal/blur)
(def focus ui.codemirror.api.modal/focus)


(def current-line-number ui.codemirror.api.position/current-line-number)

(def cursor-position ui.codemirror.api.position/cursor-position)

