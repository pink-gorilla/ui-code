(ns ui.code.goldly.core
  (:require
   [re-frame.core :as rf]
   [pinkie.pinkie :refer-macros [register-component]]
   [ui.codemirror.core :refer [configure-cm-globally!]]
   [ui.code.highlight.viewer :refer [code-viewer]]
   [ui.code.goldly.codemirror-atom :refer [codemirror-atom codemirror-atom-viewonly]]
   [ui.code.goldly.css :as css]))

(configure-cm-globally!)

(register-component :p/code code-viewer)
(register-component :p/codemirror codemirror-atom)
(register-component :p/codemirror-viewonly codemirror-atom-viewonly)

(rf/dispatch [:css/add-components css/components css/config])


