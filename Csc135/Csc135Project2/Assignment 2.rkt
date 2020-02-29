;Lorenzo Susbilla
;Csc 135
;4 April 2019
;Scheme Programming Assignment

(define (atom? x)
  (not (or (pair? x) (null? x))))

(define (digits x)
  (if (<= x 9) 1 (* 10 (digits(quotient x 10)))))
        

(define (isNeg L)
  (cond ((null? L) 0)
        ((< (car L) 0) (+ 1 (isNeg(cdr L))))
        (else (+ 0(isNeg (cdr L))))))

(define (isNeg? x)
  (if (< x 0) #T #F))

(define (remove L x)
  (cond ((null? L) '())
        ((equal? (car L) x )(remove (cdr L) x))
        (else (cons (car L) (remove (cdr L) x)))))

(define (isEven L)
 (cond ((null? L) 0)
        ((=(modulo (car L) 2)0) (+ 1 (isEven(cdr L))))
        (else (+ 0(isEven (cdr L))))))

;appendInt
(define (appendInt N M)
  (cond (( <= M 9) (+ (* N 10) M))
        ((and (< M 100)(> M 9))(appendInt (+ (* N 10) (quotient M 10)) (modulo M 10)))
        (else (appendInt (+ (* N 10)(quotient M (digits M))) (modulo M (digits M))))))
;listsMax
(define (listsMax L M)
  (cond ((null? L) '())
        ((atom? (cdr L))(cons(car L) (max(cdr L) (cdr M))))
        (else (cons(max(car L) (car M)) (listsMax (cdr L) (cdr M))))))
;cycler
(define (cycler L int)
  (cond((null? L) int)
       ((= (length L) 1) (+ (car L) int))
       ((= (length L) 2) (- (+ int (car L)) (cadr L)))
  (else(cycler (cdddr L)(* (caddr L) (- (+ int (car L)) (cadr L)))))))
;function winner
(define (functionWinner f L M)
  (if (> (f L) (f M)) 1 2))
;countTrue
(define (countTrue L f)
  (cond ((null? L) 0)
        ((and (atom?(car L))(f(car L))) (+ 1 (countTrue f (cdr L))))
        ((list?(car L))(+ (countTrue f (cdr L))(countTrue f (car L))))
        (else (countTrue f (cdr L)))))
;badNumberRemover
(define (badNumberRemover L)
  (if (null? (cdr L)) (lambda(M) (remove M (car L))) (lambda(M)(append(remove M (car L))(badNumberRemover (cdr L))))))
      
(define B (badNumberRemover '(42 13 4)))