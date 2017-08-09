(ns djp-front.core
  (:require  [reagent.core :as reagent :refer [atom]]
             [djp-front.fn :refer [go-home go-location open-dev]]))

(defonce state (atom {:message "Hello Reagent world"}))

(defn is-enter-key [%]
  (let [key-code (-> % .-keyCode)]
    (= key-code 13)))


(defn ctrl []
  [:div {:id "controls"}
   [:button {:id "back", :title "Go Back", :disabled "true"} "◀"]
   [:button {:id "forward", :title "Go Forward", :disabled "true"} "▶"]
   [:button {:id "home" :on-click #(go-home) :title "Go Home"} "⌂"]
   [:button {:id "reload", :title "Reload"} "⟳"]
   ;;[:form {:id "location-form"}
   [:div {:id "center-column"}
    [:input {:id "location", :type "text", :default-value "http://www.github.com/"}]]
   [:button {:title "Go" :on-click #(go-location)} "Go"]
   ;;]
   [:button {:id "zoom", :title "Change Zoom" :on-click #(open-dev)} "🔎"]
   [:button {:id "find", :title "Find in Page"} "🔦"]
   ]
  )
(defn zoom []
  [:div {:id "zoom-box"}
   [:form {:id "zoom-form"}
    [:input {:id "zoom-text", :type "text"}]
    [:input {:type "submit", :value "🔎"}]
    [:button {:id "zoom-in"} "➕"]
    [:button {:id "zoom-out"} "➖"]
    ]]
  )

(defn find-box []
  [:div {:id "find-box"}
   [:form {:id "find-form"}
    [:input {:id "find-text", :type "text"}]
    [:div {:id "find-results"}]
    [:input {:type "submit", :style {:position "absolute" :visibility "hidden"}}]
    [:button {:id "match-case"} "aA"]
    [:button {:id "find-backward"} "&lt;"]
    [:button {:id "find-forward"} "&gt;"]
    ]]
  )

(defn tool-bar []
  [:div {:style {:height 80}}
   [ctrl]
   [zoom]
   [find-box]
   ]
  )
(defn root-component []
  [:div
   [tool-bar]
   [:webview {:src "http://lab.ucode.cc", :style {:width "100%" :height "96%"}}]
   [:div {:id "sad-webview"}
    [:div {:id "sad-webview-icon"} "☢"]
    [:h2 {:id "crashed-label"} "Aw, Snap!"]
    [:h2 {:id "killed-label"} "He&#39;s Dead, Jim!"]
    [:p "Something went wrong while displaying this webpage.\nTo continue, reload or go to another page."]
    ]
   ]
  )

(defn mount-root [setting]
  (reagent/render [root-component]
                  (.getElementById js/document "app")))

(defn init! [setting]
  (mount-root setting))
