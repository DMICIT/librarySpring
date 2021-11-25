INSERT INTO books (author, book_name, book_edition,release_date) value('Джон Р. Р. Толкин', 'Властелин колец', 'Allen & Unwin', '1954-01-01');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Джон Р. Р. Толкин', 'Властелин колец', 'Allen & Unwin', '1954-01-01');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Джейн Остен', 'Гордость и предубеждение', 'George Allen', '1894-01-02');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Михаил Булгаков', 'Мастер и Маргарита', 'Test Edition 2', '2002-10-31');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Федор Достоевский', 'Преступление и наказание 2', 'Test Edition 3', '2002-11-08');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Антуан де Сент-Экзюпери', 'Маленький принц', 'Test Edition 4', '2002-11-08');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Михаил Булгаков', 'Собачье сердце', 'Test Edition 5', '2002-11-09');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Эрих Мария Ремарк', 'Три товарища', 'Test Edition 6', '2002-11-09');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Джером Сэлинджер', 'Над пропастью во ржи', 'Test Edition 7', '2002-11-08');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Михаил Лермонтов', 'Герой нашего времени', 'Test Edition 9', '2002-11-09');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Артур Конан Дойл', 'Приключения Шерлока Холмса', 'Test Edition 12', '2002-11-09');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Оскар Уайльд', 'Портрет Дориана Грея', 'Test Edition 14', '2002-11-09');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Марио Пьюзо', 'Крестный отец', 'Test Edition 12', '2002-11-09');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Эрих Мария Ремарк', 'Триумфальная арка', 'Test Edition21', '2002-11-09');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Николай Васильевич Гоголь', 'Мертвые души', 'Edition2', '2002-11-08');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Колин Маккалоу', 'Поющие в терновнике', 'Test Edition23', '2002-11-08');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Эрих Мария Ремарк', 'На западном фронте без перемен', 'Test Edition33', '2002-11-09');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Эмили Бронте', 'Грозовой перевал', 'Edition', '2002-11-09');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Стивен Кинг', 'Зеленая Миля', 'RUTest Edition', '2002-11-09');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Габриэль Гарсиа Маркес', 'Сто лет одиночества', 'Test Edition EN', '2002-11-09');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Федор Достоевский', 'Идиот', 'Test Edition', '2002-11-10');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Виктор Гюго', 'Отверженные', 'FRest Edition', '2002-11-09');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Виктор Гюго', 'Человек который смеется', 'Test Edition', '2002-11-10');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Михаил Булгаков', 'Белая Гвардия', 'ENTest Edition', '2002-11-09');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Николай Васильевич Гоголь', 'Вий', 'Test Edition', '2002-11-10');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Николай Васильевич Гоголь', 'Вечера на хуторе близ Диканьки', 'Test Edition', '2002-11-10');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Михаил Булгаков', 'Мастер и Маргарита,.', 'Test Edition', '2002-11-04');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Михаил Булгаков', 'Собачье сердце', 'Edition 1', '2002-11-08');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE (' The Great Gatsby', 'F. Scott Fitzgerald', 'Jazz Age', '1990-12-13');
INSERT INTO books (author, book_name, book_edition, release_date) VALUE ('Herman Melville', 'Moby Dick', 'American Edition', '1850-12-31');

INSERT INTO users ( name, email, gender, phone, role, ban_list, password) VALUES ('admin', 'admin@gmail.com', 'man', '777', 'admin', 0, 'admin');
INSERT INTO users ( name, email, gender, phone, role, ban_list, password) VALUES ( 'librarian', 'librarian@text.com', 'man', '12345', 'librarian', 0, 'librarian1');
INSERT INTO users ( name, email, gender, phone, role, ban_list, password) VALUES ('user1', 'user1@test.com', 'woman', '12345', 'user', 0, 'user1');
INSERT INTO users ( name, email, gender, phone, role, ban_list, password) VALUES ('user2', 'user2@test.com', 'man', '12345', 'user', 0, 'user2');

INSERT INTO catalog ( book_id, count) VALUES ( 1, 32);
INSERT INTO catalog ( book_id, count) VALUES ( 2, 20);
INSERT INTO catalog ( book_id, count) VALUES ( 21, 11);


INSERT INTO orders (book_id,user_id, book_spot, status, return_date) VALUES ( 2, 2, 'abonement', 'checked out', '2021-12-11');


