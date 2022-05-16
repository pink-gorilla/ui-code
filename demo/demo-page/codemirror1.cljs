
(defn get-code1 [id]
  (-> (cm/get id)
      (cm/get-code)))

(defn set-code1 [id code]
  (let [c (cm/get id)]
     (cm/set-code c code)
     (cm/focus c)))

(defn eval1 [id]
  (info (str "codemirror eval:" (get-code1 id))))

(defn print-position1 [id]
  (-> (cm/get id)
      (cm/cursor-position)
      (info)))

(defn codemirror-unbound-page [url-params]
  (let [id 66
        opts {}]
  [:div.bg-blue-300.p-5.w-screen.h-screen
      [:p "unbound codemirror"]
      [:p "eval button click will just print the code to the browser console."]
      [:p "position button click will just print the current position to the browser console."]
      [:button.border.border-round.p-1.bg-green-500 {:on-click #(eval1 id)} "eval"]
      [:button.border.border-round.p-1.bg-green-500 {:on-click #(set-code1 id "(* 9 9 9)")} "load-code 1"]
      [:button.border.border-round.p-1.bg-green-500 {:on-click #(set-code1 id "(* 2 2 2)")} "load-code 2"]
      [:button.border.border-round.p-1.bg-green-500 {:on-click #(print-position1 id)} "position"]
      [cm/style-inline]
      [:div.my-codemirror
        [user/codemirror-unbound id opts]]]))


(add-page codemirror-unbound-page :codemirror-demo-page)




