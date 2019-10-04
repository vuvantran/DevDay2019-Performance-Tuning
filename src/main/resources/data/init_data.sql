--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

-- Started on 2019-10-02 08:50:08

SET client_encoding = 'UTF8';


-- delete from book_tags;
-- delete from book_comments;
-- delete from book_details;
-- delete from books;
--
-- TOC entry 2890 (class 0 OID 47372)
-- Dependencies: 205
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.books (id, author, name, serial_number) VALUES (1, 'E. B. White', 'Charlotte''s Web', '059030271X');
INSERT INTO public.books (id, author, name, serial_number) VALUES (2, 'R. L. Stine', 'Piano Lessons Can Be Murder (Goosebumps, No 13)', '590494481');
INSERT INTO public.books (id, author, name, serial_number) VALUES (3, 'K.A. Applegate', 'The Reaction (Animorphs, No 12)', '590997343');
INSERT INTO public.books (id, author, name, serial_number) VALUES (4, 'Anne Rivers Siddons', 'Fault Lines', '61093343');
INSERT INTO public.books (id, author, name, serial_number) VALUES (5, 'R. L. Stine', 'Phantom of the Auditorium (Goosebumps, No 24)', '590483544');
INSERT INTO public.books (id, author, name, serial_number) VALUES (6, 'Jean M. Auel', 'MAMMOTH HUNTERS,THE (Auel, Jean M. , Earth''s Children.)', '553260960');
INSERT INTO public.books (id, author, name, serial_number) VALUES (7, 'Rebecca Wells', 'Divine Secrets of the Ya-Ya Sisterhood: A Novel', '60173289');
INSERT INTO public.books (id, author, name, serial_number) VALUES (8, 'R. L. Stine', 'Night of the Living Dummy II  (Goosebumps, No 31)', '590483498');
INSERT INTO public.books (id, author, name, serial_number) VALUES (9, 'Dean Koontz', 'Midnight', '425194515');
INSERT INTO public.books (id, author, name, serial_number) VALUES (10, 'R. L. Stine', 'You Can''t Scare Me! (Goosebumps, No 15)', '590494503');
INSERT INTO public.books (id, author, name, serial_number) VALUES (11, 'R. L. Stine', 'The Abominable Snowman of Pasadena (Goosebumps, No 38)', '590568752');
INSERT INTO public.books (id, author, name, serial_number) VALUES (12, 'E. B. White', 'Charlotte''s Web (Trophy Newbery)', '64400557');
INSERT INTO public.books (id, author, name, serial_number) VALUES (13, 'Scott O''Dell', 'Island of the Blue Dolphins', '440439884');
INSERT INTO public.books (id, author, name, serial_number) VALUES (14, 'Ann M. Martin', 'Claudia and the New Girl (Baby-Sitters Club, 12)', '590251678');
INSERT INTO public.books (id, author, name, serial_number) VALUES (15, 'C. S. Lewis', 'The Magician''s Nephew (The Chronicles of Narnia)', '64471101');
INSERT INTO public.books (id, author, name, serial_number) VALUES (16, 'Kevin Anderson', 'Jedi Search (Star Wars: The Jedi Academy Trilogy, Vol. 1)', '553297988');
INSERT INTO public.books (id, author, name, serial_number) VALUES (17, 'Scott O''Dell', 'Island of the Blue Dolphins', '440940001');
INSERT INTO public.books (id, author, name, serial_number) VALUES (18, 'Amanda Quick', 'The River Knows', '515144363');
INSERT INTO public.books (id, author, name, serial_number) VALUES (19, 'Nora Roberts', 'Remember When', '425195473');
INSERT INTO public.books (id, author, name, serial_number) VALUES (20, 'Jerry B. Jenkins', 'Facing the Future (Left Behind: The Kids #4)', '842321969');
INSERT INTO public.books (id, author, name, serial_number) VALUES (21, 'Jerry B. Jenkins', 'Nicolae High (Left Behind: The Kids #5)', '842343253');
INSERT INTO public.books (id, author, name, serial_number) VALUES (22, 'C. S. Lewis', 'The Magician''s Nephew', '20442300');
INSERT INTO public.books (id, author, name, serial_number) VALUES (23, 'R. L. Stine', 'The Barking Ghost (Goosebumps, No 32)', '590483447');
INSERT INTO public.books (id, author, name, serial_number) VALUES (24, 'Ann M. Martin', 'Dawn''s Wicked Stepsister (Baby-Sitters Club, 31)', '590424971');
INSERT INTO public.books (id, author, name, serial_number) VALUES (25, 'Kimberly Willis Holt', 'My Louisiana Sky', '440415705');
INSERT INTO public.books (id, author, name, serial_number) VALUES (26, 'Nora Roberts', 'Waiting for Nick / Considering Kate (Stanislaski, Books 5 & 6) (Stanislaski Stories)', '037328568X');
INSERT INTO public.books (id, author, name, serial_number) VALUES (27, 'Judy Blume', 'Otherwise Known as Sheila the Great', '440467012');
INSERT INTO public.books (id, author, name, serial_number) VALUES (28, 'Ann M. Martin', 'Bsc #04: Mary Anne Saves The Day (Baby-Sitters Club: Collector''s Edition)', '590251597');
INSERT INTO public.books (id, author, name, serial_number) VALUES (29, 'Ann M. Martin', 'Mary Anne Saves the Day (Baby-Sitters Club, 4)', '590435124');
INSERT INTO public.books (id, author, name, serial_number) VALUES (30, 'Ann M. Martin', 'The Ghost at Dawn''s House (The Baby-Sitters Club #9)', '590435086');
INSERT INTO public.books (id, author, name, serial_number) VALUES (31, 'Ann M. Martin', 'Karens Prize (Baby-Sitters Little Sister, 11)', '590436503');
INSERT INTO public.books (id, author, name, serial_number) VALUES (32, 'Jack Canfield', 'Chicken Soup for the Preteen Soul - 101 Stories of Changes, Choices', '1558748008');
INSERT INTO public.books (id, author, name, serial_number) VALUES (33, 'K.A. Applegate', 'Animorphs Megamorphs #01: The Andalite''s Gift (Animorphs)', '590213040');
INSERT INTO public.books (id, author, name, serial_number) VALUES (34, 'R. L. Stine', 'Return of the Mummy (Goosebumps, No 23)', '590477455');
INSERT INTO public.books (id, author, name, serial_number) VALUES (35, 'Ann M. Martin', 'Baby-sitters Little Sister #1:  Karen''s Witch', '590443003');
INSERT INTO public.books (id, author, name, serial_number) VALUES (36, 'Rick Warren', 'The Purpose-Driven Life: What on Earth Am I Here For?', NULL);
INSERT INTO public.books (id, author, name, serial_number) VALUES (37, 'Patricia Gaffney', 'Circle of Three: A Novel', '61098361');
INSERT INTO public.books (id, author, name, serial_number) VALUES (38, 'V.C. Andrews', 'Into the Garden (Wildflowers)', '671007718');
INSERT INTO public.books (id, author, name, serial_number) VALUES (39, 'John Grisham', 'PLAYING FOR PIZZA', '440244714');
INSERT INTO public.books (id, author, name, serial_number) VALUES (40, 'R. L. Stine', 'Welcome to Camp Nightmare (Goosebumps, No 9)', '590466194');
INSERT INTO public.books (id, author, name, serial_number) VALUES (41, 'K.A. Applegate', 'The Warning (Animorphs, No. 16)', '590494309');
INSERT INTO public.books (id, author, name, serial_number) VALUES (42, 'jeffrey archer', 'A Twist in the Tale', '340493534');
INSERT INTO public.books (id, author, name, serial_number) VALUES (43, 'Lynne Reid Banks', 'The Secret of the Indian (Indian in the Cupboard)', '380710404');
INSERT INTO public.books (id, author, name, serial_number) VALUES (44, 'R. L. Stine', 'Be Careful What You Wish For... (Goosebumps, No 12)', '590494473');
INSERT INTO public.books (id, author, name, serial_number) VALUES (45, 'R.L. Stine', 'Broken Hearts (Fear Street Superchiller)', '671786091');
INSERT INTO public.books (id, author, name, serial_number) VALUES (46, 'Ann M. Martin', 'Karen''s Roller Skates (Baby-Sitters Little Sister #2)', '590442597');
INSERT INTO public.books (id, author, name, serial_number) VALUES (47, 'Ann M. Martin', 'Karen''s Grandmothers (Baby-Sitters Little Sister, 10)', '590436511');
INSERT INTO public.books (id, author, name, serial_number) VALUES (48, 'Ann M. Martin', 'Karen''s Haircut (Baby-Sitters Little Sister (Paperback))', '590426702');
INSERT INTO public.books (id, author, name, serial_number) VALUES (49, 'Mildred D. Taylor', 'Roll of Thunder, Hear My Cry', '014034893X');
INSERT INTO public.books (id, author, name, serial_number) VALUES (50, 'John Cassidy', 'Juggling for the Complete Klutz', '932592007');

--
-- TOC entry 2884 (class 0 OID 47345)
-- Dependencies: 199
-- Data for Name: book_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.book_details (id, description, source, cover_url, book_id) VALUES (1, 'Convinced that there is something creepy about his new piano  teacher, Jerry soon hears terrifying stories about Dr. Shreek''s music  school and students who never completed their lesson alive. \n\n', 0,'https://covers.openlibrary.org/b/id/6967248-L.jpg',  2);
INSERT INTO public.book_details (id, description, source, cover_url, book_id) VALUES (2, 'Years of caring for her needy family have left Merritt Fowler exhausted and confused, uncertain of who she is or what she wants. When a family argument sends her lovely, fragile daughter, Glynn, running from her Atlanta home to her Aunt Laura in Hollywood, Merritt is compelled to follow.   On impulse, the trio takes off in Laura''s red Mustang convertible, barreling up the coast to the lush wilderness outside San Francisco -- earthquake country. There, amid the beauty and protection of the mounta', 0, 'https://covers.openlibrary.org/w/id/3817989-L.jpg', 4);
INSERT INTO public.book_details (id, description, source, cover_url, book_id) VALUES (3, '“A big, blowzy romp through the rainbow eccentricities of three generations of crazy bayou debutantes.”—Atlanta Journal-Constitution“A very entertaining and, ultimately, deeply moving novel about the complex bonds between mother and daughter.”—Washington Post“Mary McCarthy, Anne Rivers Siddons, and a host of others have portrayed the power and value of female friendships, but no one has done it with more grace, charm, talent, and power than Rebecca Wells.”—Richmond Times-Dispat', 0, 'https://covers.openlibrary.org/w/id/40374-L.jpg', 7);
INSERT INTO public.book_details (id, description, source, cover_url, book_id) VALUES (4, 'Requesting a new dummy when her old one loses its head, young  ventriloquist Amy receives Slappy, a strange, used dummy that moves of  its own accord and disrupts things with the intent of making Amy''s life  miserable.\n\n', 0,'https://covers.openlibrary.org/w/id/384578-L.jpg', 8);
INSERT INTO public.book_details (id, description, source, cover_url, book_id) VALUES (5, 'The citizens of Moonlight Cove are changing. Some are losing touch with their deepest emotions. Others are surrendering to their wildest urges. And the few who remain unchanged are absolutely terrified—if not brutally murdered in the dead of night. Enter the shocking world of Moonlight Cove, where four unlikely survivors confront the darkest realms of human nature...\n\n', 0, 'https://covers.openlibrary.org/w/id/272715-L.jpg', 9);
INSERT INTO public.book_details (id, description, source, cover_url, book_id) VALUES (6, 'Eddie and his friends plan to dress up as the slimy Mud  Monsters--legendary spooks who supposedly live in Muddy Creek--but  their plans change when they meet the real Mud Monsters.\n\n', 0, 'https://covers.openlibrary.org/w/id/8274251-L.jpg', 10);
INSERT INTO public.book_details (id, description, source, cover_url, book_id) VALUES (7, 'Cooper, a nervous newcomer to the town, and his friend Margaret  are targeted by two evil dogs who cast a spell to switch bodies with  the children as a way of wreaking further havoc. \n\n', 0, 'https://covers.openlibrary.org/b/id/278498-L.jpg', 23);
INSERT INTO public.book_details (id, description, source, cover_url, book_id) VALUES (8, 'Tiger Ann Parker is smart in school and good at baseball, but she''s forever teased about her family by the girls in class. Tiger Ann knows her folks are different from others in their small town of Saitter, Louisiana. They are mentally slow, and Tiger Ann keeps her pain and embarrassment hidden as long as her strong and smart Granny runs the household. Then Granny dies suddenly and Aunt Dorie Kay arrives, offering Tiger Ann a way out. Now Tiger Ann must make the most important decision of her li', 0, 'https://covers.openlibrary.org/w/id/579933-L.jpg', 25);
INSERT INTO public.book_details (id, description, source, cover_url, book_id) VALUES (9, 'Sheila Tubman sometimes wonders who she really is: the outgoing, witty, and capable Sheila the Great, or the secret Sheila, who''s afraid of the dark, spiders, swimming, and dogs.When her family spends the summer in Tarrytown, Sheila has to face some of her worst fears. Not only does a dog come with the rented house, but her parents expect Sheila to take swimming lessons! Sheila does her best to pretend she''s an expert at everything, but she knows she isn''t fooling her new best friend, Mouse Elli', 0, 'https://covers.openlibrary.org/w/id/8564268-L.jpg',  27);
INSERT INTO public.book_details (id, description, source, cover_url, book_id) VALUES (10, 'Rick Dockery was the third-string quarterback for the Cleveland Browns. In the AFC Championship game, to the surprise and dismay of virtually everyone, Rick actually got into the game. With a 17-point lead and just minutes to go, Rick provided what was arguably the worst single performance in the history of the NFL. Overnight, he became a national laughingstock—and was immediately cut by the Browns and shunned by all other teams. But all Rick knows is football, and he insists that his agent fi', 0, 'https://covers.openlibrary.org/w/id/1190235-L.jpg', 39);
INSERT INTO public.book_details (id, description, source, cover_url, book_id) VALUES (11, 'Jake has made an amazing discovery: a web site about the Yeerks. Should the Animorphs investigate? If they do, they might walk right into a trap. And if they don''t, they''ll never know if they''re fighting their enemies alone. (Digest) .\n\n', 0, 'https://covers.openlibrary.org/w/id/384719-L.jpg', 41);
INSERT INTO public.book_details (id, description, source, cover_url, book_id) VALUES (12, 'No one can weave a web of suspense, deliver a jolt of surprise, or teach a lesson in living like bestselling author Jeffrey Archer. From Africa to the Middle East, and from London to Beijing, Archer takes us to places we''ve never seen and introduces us to people we''ll never forget.Meet the philandering husband who thinks he''s committed the perfect murder; the self-assured chess champion who plays a beautiful woman for stakes far higher than cash; and the finance minister who needs to crack the s', 0,'https://covers.openlibrary.org/w/id/8021494-L.jpg', 42);
INSERT INTO public.book_details (id, description, source, cover_url, book_id) VALUES (13, 'Winner of the Newbery Medal A New York Times Book Review Best of Children''s Books A National Book Award NomineeWhy is the land so important to Cassie''s family? It takes the events of one turbulent year—the year of the night riders and the burnings, the year a white girl humiliates Cassie in public simply because she''s black—to show Cassie that having a place of their own is the Logan family''s lifeblood. It is the land that gives the Logans their courage and pride—no matter how others may d', 0, 'https://covers.openlibrary.org/w/id/101898-L.jpg', 49);



--
-- TOC entry 2882 (class 0 OID 47334)
-- Dependencies: 197
-- Data for Name: book_comments; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (1, 'A little damage to the back cover, but otherwise great condition.', NULL, 1, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (2, 'Brooke''s best friend, Zeke, has been given the lead role in the school lay, The Phantom. Zeke''s totally into it. He loves dressing up in the grotesque phantom costume. And scaring the other members of the cast. Brooke thinks Zeke''s getting a little too into it. But then really scary things start happening. A messsage appears on a piece of scenery: The Phantom Strikes! A stage light comes crashing down. Is someone trying to ruin the play? Or is there really a phantom living under the stage?', NULL, 2, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (3, 'Explores the emotional baggage we all carry from past relationships - and how it affects present and future relationships, and how important forgiveness is sometimes.  Sad, funny, thoughtful.', NULL, 3, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (4, 'Amy''s ventriloquist dummy, Dennis, keeps losing his head...for real. So Amy begs her family for a new dummy. That''s when her dad finds Slappy in a local pawnshop. Slappy is kind of ugly, but at least his head stays on! Besides, Amy''s having fun practicing her new routine. There''s something odd about Slappy; something not quite right.  It''s like this dummy knows what she''s thinking.', NULL, 3, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (5, 'excellent condition', NULL, 4, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (6, 'It was a really good book.', NULL, 5, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (7, 'This book is part of the Accelerated Reader program used in many schools across the country.    It is reading level 4.5, worth 5.0 AR points.', NULL, 6, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (8, 'Know a young person? Get them off the street and into a book -- this one''s a great one to get them thinking and using their imagination.', NULL, 6, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (9, 'Amazon.com\r\nScott O''Dell won the Newbery Medal for Island of the Blue Dolphins in 1961, and in 1976 the Children''s Literature Association named this riveting story one of the 10 best American children''s books of the past 200 years. O''Dell was inspired by the real-life story of a 12-year-old American Indian girl, Karana. The author based his book on the life of this remarkable young woman who, during the evacuation of Ghalas-at (an island off the coast of California), jumped ship to stay with h', NULL, 7, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (10, 'This is a great book, For the young and old. My 12 year old daughter enjoyed this book ever so much!!!', NULL, 7, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (11, 'In the Pacific there is an island that looks like a big fish sunning itself in the sea. Around it, blue dolphins swim, otters play, and sea elephants and sea birds abound. Once, Indians also lived on the island. And when they left and sailed to the east, one young girl was left behind. \r\n\r\nThis is the story of Karana, the Indian girl who lived alone for years on the Island of the Blue Dolphins. Year after year, she watched one season pass into another and waited for a ship to take her away. ', NULL, 7, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (12, 'I loved this book very much as a child, read it again as a teen. It sets ones senses to wander...the sensitivity of this writer takes you to places beyond imagining. Adults will also be captivated by this true story of the bravery of a young woman and a life well lived, on an island, alone. I am planning to read my daughter book again very soon, and I don''t believe i have ever read any book so happily as this one, knowing how this girls story rewards the soul.', NULL, 7, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (13, 'I read this book as a child. Then I went to the beach to see if I could see San Nicholas Island. It was thrilling to read history right from where I was. Also thrilled when my son''s class read it for school.Its  a good book', NULL, 7, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (14, 'good condition. cover is slightly different then the one shown.', NULL, 8, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (15, 'From Amazon.com:\r\n\r\nAmazon.com\r\nThis large, deluxe hardcover edition of the first title in the classic Chronicles of Narnia series, The Magician''s Nephew, is a gorgeous introduction to the magical land of Narnia. The many readers who discovered C.S. Lewis''s Chronicles through The Lion, the Witch, and the Wardrobe will be delighted to find that the next volume in the series is actually the first in the sequence--and a step back in time. In this unforgettable story, British schoolchildren Po', NULL, 9, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (16, 'Loved the whole series.  Beautiful on the surface...and thought provoking deep within.', NULL, 9, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (17, 'A great series.', NULL, 10, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (18, 'My daughters liked this book.', NULL, 11, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (19, 'This is a great series that my 9 year old son and I are reading together.  I had read the adult series and this is interesting to me also.  As it follows along the same story line as the adult books.', NULL, 12, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (20, 'I liked Tiger Ann Parker, the heroine, whose parents are slow, and whose grandmother runs the household.  This is a Young Adult read, although any agegroup will find something to take away from in this book.', NULL, 13, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (21, 'A great book that I read with my bible study group, but can be read at anytime in your life, even if you don''t attend church.', NULL, 10, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (22, 'I breezy read, not earth shaking in the least for diffrent for Grisham', NULL, 11, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (23, 'I loved this book.  Grisham is an expert storyteller.  The book was also an excellant tour guide of Italy.', NULL, 12, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (24, 'great book great part of a series', NULL, 13, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (25, 'A collection of short stories that do not turn out as you expected. Love/hate. Loved the stories, hated that they ended without more. lol\r\nA few AMAZING ones! Just Good Friends was my absolute favorite!!', NULL, 13, NULL);
INSERT INTO public.book_comments (id, content, parent, book_detail_id, user_id) VALUES (26, 'Make a wish! Samantha Byrd is a klutz... an accident waiting to happen. She''s the laughingstock of the girls'' basketball team. And that mean, rotten Judith Bellwood is making her life miserable on and off the court. But everything''s about to change. Sam''s met someone who can grant her three wishes. For real. Too bad Sam wasn''t careful what she wished for. Because her wishes are coming true. And they''re turning her life into a living nightmare!', NULL, 13, NULL);


--
-- TOC entry 2848 (class 0 OID 47364)
-- Dependencies: 203
-- Data for Name: book_tags; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (1, 'Children''s Books', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (2, 'Spine-Chilling Horror', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (3, 'Genealogy', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (4, 'Words, Language & Grammar', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (5, 'Foreign Language Study & Reference', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (6, 'Atlases & Maps', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (7, 'Test Preparation', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (8, 'Survival & Emergency Preparedness', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (9, 'Careers', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (10, 'Almanacs & Yearbooks', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (11, 'Quotations', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (12, 'Dictionaries & Thesauruses', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (13, 'Writing, Research & Publishing Guides', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (14, 'Catalogs & Directories', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (15, 'Cartoons', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (16, 'Jokes & Riddles', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (17, 'Etiquette', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (18, 'Encyclopedias & Subject Guides', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (19, 'Science Fiction & Fantasy', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (20, 'Humor', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (21, 'Consumer Guides', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (22, 'Reference', 1);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (23, 'Romance', 2);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (24, 'Literature & Fiction', 2);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (25, 'Mothers & Children', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (26, 'Literature & Fiction', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (27, 'Friendship', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (28, 'Women''s Fiction', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (29, 'African American', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (30, 'Genre Fiction', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (31, 'Classics', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (32, 'Family Saga', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (33, 'Hispanic', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (34, 'Poetry', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (35, 'Humor', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (36, 'Literary', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (37, 'Asian American', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (38, 'Drama', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (39, 'Anthologies', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (40, 'Native American', 3);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (41, 'Horror', 4);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (42, 'Science Fiction & Fantasy', 4);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (43, 'Teen & Young Adult', 4);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (44, 'Humorous', 4);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (45, 'Literature & Fiction', 4);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (46, 'Erotic Horror', 5);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (47, 'Mystery, Thriller & Suspense', 5);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (48, 'Literature & Fiction', 5);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (49, 'Horror', 5);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (50, 'Thrillers & Suspense', 5);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (51, 'Genre Fiction', 5);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (52, 'Suspense', 5);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (53, 'Dark Fantasy', 5);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (54, 'Ghosts', 5);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (55, 'British & Irish', 5);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (56, 'Occult', 5);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (57, 'Anthologies', 5);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (58, 'Reference', 5);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (59, 'Vampires', 5);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (60, 'Children''s Books', 6);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (61, 'Science Fiction & Fantasy', 6);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (62, 'Spine-Chilling Horror', 6);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (63, 'Horror', 7);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (64, 'Teen & Young Adult', 7);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (65, 'Science Fiction & Fantasy', 7);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (66, 'Literary Criticism & Collections', 8);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (67, 'Children''s Books', 8);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (68, 'Chapter Books & Readers', 8);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (69, 'Literature & Fiction', 8);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (70, 'Multigenerational', 8);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (71, 'Short Story Collections', 8);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (72, 'Family Life', 8);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (73, 'Poetry', 8);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (74, 'Growing Up & Facts of Life', 8);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (75, 'Historical Fiction', 8);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (76, 'Religious Fiction', 8);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (77, 'Friendship', 9);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (78, 'Jokes & Riddles', 9);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (79, 'Cartoons', 9);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (80, 'Self-Esteem & Self-Respect', 9);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (81, 'Children''s Books', 9);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (82, 'Growing Up & Facts of Life', 9);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (83, 'Humor', 9);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (84, 'Friendship, Social Skills & School Life', 9);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (85, 'Business & Investing', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (86, 'Children''s Books', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (87, 'Education & Reference', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (88, 'Crafts, Hobbies & Home', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (89, 'Mystery, Thriller & Suspense', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (90, 'Literature & Fiction', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (91, 'Politics & Social Sciences', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (92, 'Medical Books', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (93, 'Professional & Technical', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (94, 'Humor & Entertainment', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (95, 'Cookbooks, Food & Wine', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (96, 'Sports & Outdoors', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (97, 'Self-Help', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (98, 'Health, Fitness & Dieting', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (99, 'Comics & Graphic Novels', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (100, 'Science Fiction & Fantasy', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (101, 'Science & Math', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (102, 'Religion & Spirituality', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (103, 'History', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (104, 'Christian Books & Bibles', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (105, 'Parenting & Relationships', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (106, 'Law', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (107, 'Computers & Technology', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (108, 'Romance', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (109, 'Gay & Lesbian', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (110, 'Arts & Photography', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (111, 'Calendars', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (112, 'Travel', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (113, 'Teen & Young Adult', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (114, 'Biographies & Memoirs', 10);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (115, 'Literature & Fiction', 11);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (116, 'African American', 11);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (117, 'Genre Fiction', 11);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (118, 'Classics', 11);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (119, 'Hispanic', 11);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (120, 'Poetry', 11);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (121, 'Humor', 11);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (122, 'Sports', 11);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (123, 'Literary', 11);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (124, 'Asian American', 11);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (125, 'Anthologies', 11);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (126, 'Drama', 11);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (127, 'Native American', 11);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (128, 'Children''s Books', 12);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (129, 'Fantasy & Magic', 12);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (130, 'Science Fiction & Fantasy', 12);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (131, 'Short Stories & Anthologies', 12);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (132, 'Thrillers & Suspense', 12);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (133, 'Short Stories', 12);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (134, 'Suspense', 12);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (135, 'Mystery, Thriller & Suspense', 12);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (136, 'Literature & Fiction', 12);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (137, '20th Century', 13);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (138, 'Prejudice & Racism', 13);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (139, 'Classics', 13);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (140, 'Historical Fiction', 13);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (141, 'Teen & Young Adult', 13);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (142, 'Social & Family Issues', 13);
INSERT INTO public.book_tags (id, name, book_detail_id) VALUES (143, 'Literature & Fiction', 13);



--
-- TOC entry 2908 (class 0 OID 0)
-- Dependencies: 196
-- Name: book_comments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.book_comments_id_seq', (SELECT MAX(id) FROM book_comments));


--
-- TOC entry 2909 (class 0 OID 0)
-- Dependencies: 198
-- Name: book_details_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.book_details_id_seq',  (SELECT MAX(id) FROM book_details));




--
-- TOC entry 2911 (class 0 OID 0)
-- Dependencies: 202
-- Name: book_tags_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.book_tags_id_seq', (SELECT MAX(id) FROM book_tags));


--
-- TOC entry 2912 (class 0 OID 0)
-- Dependencies: 204
-- Name: books_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.books_id_seq',  (SELECT MAX(id) FROM books));



-- Completed on 2019-10-02 08:50:08

--
-- PostgreSQL database dump complete
--



