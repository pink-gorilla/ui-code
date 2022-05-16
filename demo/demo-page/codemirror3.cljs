
(defonce state3
  (r/atom "(+ 7 7)\n(def a 44)\n(defn test [a b] \n  (+ a b))"))

(defn eval [] 
  (info "codemirror eval:" @state3))


(defn codemirror-demo-page3 [url-params]
  [:div.bg-blue-300.p-5.w-screen.h-screen
      [:p "this snippet demonstrates to use codemirror with a atom that has text"]
      [:p "eval button click will just print the code to the browser console."]
      [:p "position button click will just print the current position to the browser console."]
      [:button.border.border-round.p-1.bg-green-500 {:on-click eval} "eval"]
      [user/codemirror 27 state3]])


(add-page codemirror-demo-page3 :codemirror-demo-page3)




