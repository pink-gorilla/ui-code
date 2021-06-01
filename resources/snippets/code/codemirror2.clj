(require '[goldly.system :as goldly])
(require '[goldly.runner :refer [system-start!]])

(system-start!
 (goldly/system
  {:id :codemirror2
   :state {:editor {:src "[:p 123]"
                    :type :pinkie}}
   :html [:div
          [:p "this snippet demonstrates to use codemirror with a atom that"]
          [:p "is a map"]
          [:p "eval button click will just print the code to browser console."]
          [:button.border.border-round.m-1 {:on-click ?eval} "eval"]
          [:p/codemirror 0 state [:editor :src]]
          [:p/codemirror-viewonly 1 state [:editor :src]]
          
          ]
   :fns {:eval (fn [] 
                 (info "codemirror eval:" @state)
                 @state
                 )}
   :fns-raw {}
  }
  {:fns {}}
  ))


; (pinkgorilla.notebook.repl/r! [canvas])


