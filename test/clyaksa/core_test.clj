(ns clyaksa.core-test
  (:require [clojure.test :refer :all]
            [clyaksa.core :refer :all])
  (:import (java.awt.image BufferedImage)))

(deftest new-image-size-test
  (testing "new image return with correct size"
    (let [size 100
          image (new-image size :rgb)]
      (is (= (class image) BufferedImage))
      (is (= (.getWidth image) size))
      (is (= (.getHeight image) size))
      (is (= (.getType image) BufferedImage/TYPE_INT_RGB)))))

(deftest new-image-width-height-test
  (testing "new image return with correct size"
    (let [width 200
          height 300
          image (new-image width height :argb)]
      (is (= (class image) BufferedImage))
      (is (= (.getWidth image) width))
      (is (= (.getHeight image) height))
      (is (= (.getType image) BufferedImage/TYPE_INT_ARGB)))))
