(ns ui.codemirror.goldly.core
  (:require
   [re-frame.core :as rf]
   [pinkie.pinkie :refer-macros [register-component]]
   [ui.codemirror.core :refer [configure-cm-globally!]]
   [ui.codemirror.goldly.codemirror-atom :refer [codemirror-atom]]
   [ui.codemirror.goldly.css :as css]))

(configure-cm-globally!)

(register-component :p/codemirror codemirror-atom)

(rf/dispatch [:css/add-components css/components css/config])


