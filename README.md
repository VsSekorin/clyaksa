# clyaksa

[![Clojars Project](https://img.shields.io/clojars/v/com.vssekorin/clyaksa.svg)](https://clojars.org/com.vssekorin/clyaksa)

### Create new image

```clojure
(new-image 1000 :rgb)           ;; 1000x1000 rgb image
(new-image 600 800 :argb)       ;; 600x800 argb image
```

Enabled image types:

- `:custom`
- `:rgb`
- `:argb`
- `:argb-pre`
- `:bgr`

### Save/Load image

Save:
```clojure
(save-image image "image.jpg")
(save-image image "image.jpg" :jpg)
```

Load:
```clojure
(load-image :file "image.png")              ;; load image from filesystem
(load-image :url "google.com/image.png")    ;; load image by url

(load-image "image.png")                    ;; image loaded from filesystem by default
```

### Image data

```clojure
(get-height image)          ;; get height of the image
```
```clojure
(get-width image)           ;; get width of the image
```

### Drawing

Color is int value.

Set pixel:
```clojure
(set-pixel image 200 300 color)         ;; return changed image
```

Get pixel:
```clojure
(get-pixel image 55 55)                 ;; return color of pixel
```

Swap pixels in one image:
```clojure
(swap-pixel image x1 y1 x2 y2)          ;; return changed image
```

Swap pixels between two image:
```clojure
(swap-pixel image1 image2 x1 y1 x2 y2)  ;; return array of changed images: [image1 image2]
```
