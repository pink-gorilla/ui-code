(ns ui.code.goldly.css
  (:require
   [webly.user.css.helper :refer [add-themes]]
   [ui.code.highlight.themes :as highlight]
   [ui.codemirror.theme :as codemirror]))

(def components
  {:highlight (add-themes
               {}
               "highlight.js/styles/%s.css"
               highlight/themes)
   ;:code-linenumber  {true ["goldly/code.css"]}
   :codemirror (add-themes
                {true ["codemirror/lib/codemirror.css"]}
                "codemirror/theme/%s.css"
                codemirror/themes)})

(def config
  {:highlight "github" ; "default"   
   ;:code-linenumber true
   :codemirror "paraiso-dark" ;true
   })