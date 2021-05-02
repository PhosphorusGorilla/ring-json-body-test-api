# Basic API project

This is a basic API project built with compojure. The project only has one file: `handler.clj` where the routes and ring handlers are configured.

### Problem

`ring-json` source [says](https://github.com/ring-clojure/ring-json#wrap-json-body) using wrap-json-body middleware with handler is enough to convert JSON request body into clojure data type, except, it doesn't seem to be converted into clojure datatype with keywords:

    $ curl -XPUT -H "Content-type: application/json" -d '{ "id": 32, "name": "pad" }' 'localhost:3001/item/5'

    {
     [...]
     :uri "/item/5",
     :query-string nil,
     :body {"id" 32, "name" "pad"},
    }

### Expected output

    {
     [...]
     :uri "/item/5",
     :query-string nil,
     :body {:id 32, :name "pad"},
    }
