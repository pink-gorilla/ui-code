(ns ui.codemirror.goldly.examples
  (:require
   [systems.snippet-registry :refer [add-snippet]]))

; codemirror examples are separate,
; because we want to be able to not load editor snippets 
; in normal goldly configurations.


(add-snippet {:type :goldly-clj
              :category :codemirror
              :id :codemirror1
              :filename "snippets/codemirror/codemirror1.clj"})