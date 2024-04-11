(ns ui.codemirror.bound
  (:require
   [ui.codemirror.bound.core]
   [ui.codemirror.bound.themed]
   [ui.codemirror.bound.atom]))


(def codemirror-atom ui.codemirror.bound.atom/codemirror-atom)
(def codemirror-atom-viewonly ui.codemirror.bound.atom/codemirror-atom-viewonly)

(def codemirror-themed ui.codemirror.bound.themed/codemirror-themed)