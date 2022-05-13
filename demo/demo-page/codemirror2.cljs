

(defonce state2
  (r/atom {:editor {:src "[:p 123]"
                    :type :pinkie}}))

(defn eval2 []
  (info "codemirror eval:" @state2)
  @state2)

(defn codemirror-demo-page2 [url-params]
  [:div.bg-blue-300.p-5.w-screen.h-screen
   [:p "this snippet demonstrates to use codemirror with a atom that"]
   [:p "is a map"]
   [:p "eval button click will just print the code to browser console."]
   [:button.border.border-round.m-1 {:on-click eval2} "eval"]
   [user/codemirror 0 state2 [:editor :src]]
   [user/codemirror-viewonly 1 state2 [:editor :src]]])


(add-page codemirror-demo-page2 :codemirror-demo-page2)
