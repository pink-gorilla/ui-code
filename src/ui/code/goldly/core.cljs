(ns ui.code.goldly.core
  (:require
   [pinkie.pinkie :refer-macros [register-component]]
   [ui.codemirror.core :refer [configure-cm-globally!]]
   [ui.code.highlight.viewer :refer [code-viewer]]
   [ui.code.goldly.codemirror-atom :refer [codemirror-atom codemirror-atom-viewonly]]))

(configure-cm-globally!)

(register-component :p/code code-viewer)
(register-component :p/codemirror codemirror-atom)
(register-component :p/codemirror-viewonly codemirror-atom-viewonly)


