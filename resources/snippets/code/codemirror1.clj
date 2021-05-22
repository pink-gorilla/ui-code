(require '[goldly.system :as goldly])
(require '[goldly.runner :refer [system-start!]])

(system-start!
 (goldly/system
  {:id :codemirror1
   :state "(+ 7 7)"
   :html [:div
          [:p "this snippet demonstrates to use codemirror with a atom that has text"]
          [:p "eval button click will just print the code to browser console."]
          [:button.border.border-round.p-1 {:on-click ?eval} "eval"]
          [:p/codemirror 0 state]]
   :fns {:eval (fn [] 
                 (info "codemirror eval:" @state)
                 @state
                 )}
   :fns-raw {}
  }
  {:fns {}}
  ))


; (pinkgorilla.notebook.repl/r! [canvas])


