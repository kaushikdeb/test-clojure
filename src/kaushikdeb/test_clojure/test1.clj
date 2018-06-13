(ns kaushikdeb.test-clojure.test1
  (:require [clj-http.lite.client :as client]
            [ring.adapter.jetty :as jetty])
  (:gen-class))


(defn test-http
  "Test how http client calls work"
  [url]
  (println "URL passed: " url)
  (when url
    (client/get url)))


(defn -main1
  "entry point for the app"
  [& args];; expects the URL to be passed in the command line
  (println "Hello, World!")
  (when (and (not (nil? args)) (> (count args) 0));; Go to the next line only if args is passed
    (println "Response status from http client call: " (get (test-http (first args)) :status))))

(defn now [] (java.util.Date.))

(defn current-time [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (str (now))})

(def ^:cons default-port 3000);; constant default port number, a global definition for this namespace

(defn -main
  "entry point 2 to test jetty server"
  [& args]
  (jetty/run-jetty current-time {:port ;;The port can optionally be passed as an command line argument
                                 (if (and (not (nil? args)) (> (count args) 0));; If commandline argument was passed
                                     (try (Integer/parseInt (first args));; See if it can be parsed to an Int
                                          (catch Exception ex default-port));; If not, use the default port 3000
                                     default-port)}));; else of if commandline param is not passed, use default port 3000

