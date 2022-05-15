(ns ui.codemirror.goldly.codemirror-api
  (:require
   [ui.codemirror.registry]
   [ui.codemirror.api.position]))

(def get-editor ui.codemirror.registry/get-editor)

(def cursor-position ui.codemirror.api.position/cursor-position)

