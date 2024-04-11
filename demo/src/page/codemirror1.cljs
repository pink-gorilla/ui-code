(ns page.codemirror1
  (:require
   [re-frame.core :as rf]
   [ui.codemirror.codemirror :refer [codemirror get-editor]]
   [ui.codemirror.api :as api]
   [ui.codemirror.theme :as theme]))

(defn get-code1 [id]
  (-> (get-editor id)
      (api/get-code)))

(defn set-code1 [id code]
  (let [c (get-editor id)]
    (api/set-code c code)
    (api/focus c)))

(defn eval1 [id]
  (println (str "codemirror eval:" (get-code1 id))))

(defn print-position1 [id]
  (-> (get-editor id)
      (api/cursor-position)
      (println)))

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
     [theme/style-codemirror-inline]
     [:div.my-codemirror
      [codemirror id opts]]]))

(rf/reg-event-fx
 :repl/eval-expression
 (fn [cofx [_ data]]
   (println (str "evaluating repl segment!" data))

   nil))



