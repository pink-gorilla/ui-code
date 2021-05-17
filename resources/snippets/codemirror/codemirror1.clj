(require '[goldly.system :as goldly])
(require '[goldly.runner :refer [system-start!]])

(println "*********************** codemirror snippet")

(system-start!
 (goldly/system
  {:id :codemirror1
   :state "(+ 7 7)"
   :html [:div
          [:button {:on-click ?eval} "eval"]
          [:p/codemirror 0 state]]
   :fns {:eval (fn [] 
                 (info "eval:" @state)
                 @state
                 )}
   :fns-raw {}
  }
  {:fns {}}
  ))


; (pinkgorilla.notebook.repl/r! [canvas])


