(ns ui.code.goldly.snippets
  (:require
   [systems.snippet-registry :refer [add-snippet]]))

; codemirror examples are separate,
; because we want to be able to not load editor snippets 
; in normal goldly configurations.

(add-snippet {:type :pinkie
              :category :code
              :id :highlightjs
              :filename "snippets/code/highlight.edn"})

(add-snippet {:type :goldly-clj
              :category :code
              :id :codemirror1
              :filename "snippets/code/codemirror1.clj"})

(add-snippet {:type :goldly-clj
              :category :code
              :id :codemirror2
              :filename "snippets/code/codemirror2.clj"})