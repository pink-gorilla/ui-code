(ns ui.codemirror.goldly.css
  (:require
   [webly.user.css.helper :refer [add-themes]]
   [ui.codemirror.theme :as codemirror]))

(def components
  {:codemirror (add-themes
                {true ["codemirror/lib/codemirror.css"]}
                "codemirror/theme/%s.css"
                codemirror/themes)})

(def config
  {:codemirror "paraiso-dark" ;true
   })