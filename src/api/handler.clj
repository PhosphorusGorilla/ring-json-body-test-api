(ns api.handler
  (:require [compojure.core :refer :all]
            [ring.middleware.json :as middleware]
            [ring.util.response :refer [response]]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] (response {:welcome "Hello world"}))
  (PUT "/item/:id" {{id :id} :params body :body} (str id ", " body))
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)))
