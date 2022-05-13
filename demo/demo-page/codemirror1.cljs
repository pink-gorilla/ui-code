
(defonce state
  (r/atom "(+ 7 7)\n(def a 44)\n(defn test [a b] \n  (+ a b))"))

(defn eval [] 
  (info "codemirror eval:" @state)
     @state)

(defn print-position []
  (-> (cm/get 27)
      (cm/cursor-position)
      (info )
      ) 
  )


(defn codemirror-demo-page [url-params]
  [:div.bg-blue-300.p-5.w-screen.h-screen
      [:p "this snippet demonstrates to use codemirror with a atom that has text"]
      [:p "eval button click will just print the code to the browser console."]
      [:p "position button click will just print the current position to the browser console."]
      [:button.border.border-round.p-1.bg-green-500 {:on-click eval} "eval"]
      [:button.border.border-round.p-1.bg-green-500 {:on-click print-position} "position"]
      [user/codemirror 27 state]])


(add-page codemirror-demo-page :codemirror-demo-page)




