-- Add new column cover_url and update the cover_url data
--

ALTER TABLE public.book_details 
ADD COLUMN cover_url VARCHAR;


UPDATE public.book_details  SET cover_url='https://covers.openlibrary.org/b/id/6967248-L.jpg' WHERE id=1 ;

UPDATE public.book_details  SET cover_url='https://covers.openlibrary.org/w/id/3817989-L.jpg' WHERE id=2 ;

UPDATE public.book_details  SET cover_url='https://covers.openlibrary.org/w/id/40374-L.jpg' WHERE id=3 ;

UPDATE public.book_details  SET cover_url='https://covers.openlibrary.org/w/id/384578-L.jpg' WHERE id=4 ;

UPDATE public.book_details  SET cover_url='https://covers.openlibrary.org/w/id/272715-L.jpg' WHERE id=5 ;

UPDATE public.book_details  SET cover_url='https://covers.openlibrary.org/w/id/8274251-L.jpg' WHERE id=6 ;

UPDATE public.book_details  SET cover_url='https://covers.openlibrary.org/b/id/278498-L.jpg' WHERE id=7 ;

UPDATE public.book_details  SET cover_url='https://covers.openlibrary.org/w/id/579933-L.jpg' WHERE id=8 ;

UPDATE public.book_details  SET cover_url='https://covers.openlibrary.org/w/id/8564268-L.jpg' WHERE id=9 ;

UPDATE public.book_details  SET cover_url='https://covers.openlibrary.org/w/id/1190235-L.jpg' WHERE id=10 ;

UPDATE public.book_details  SET cover_url='https://covers.openlibrary.org/w/id/384719-L.jpg' WHERE id=11 ;

UPDATE public.book_details  SET cover_url='https://covers.openlibrary.org/w/id/8021494-L.jpg' WHERE id=12 ;

UPDATE public.book_details  SET cover_url='https://covers.openlibrary.org/w/id/101898-L.jpg' WHERE id=13 ;



