CREATE TABLE IF NOT EXISTS Content(
	id SERIAL primary key,
	title varchar(255) NOT NUll,
	description text,
	status varchar(20) NOT NUll,
	content_type varchar(20) NOT NUll,
	date_created TIMESTAMP NOT NUll,
	date_updated TIMESTAMP,
	url varchar(255)
);

-- Insert into Content(title, desc, status, content_type, date_created, url)
-- Values('My first Spring App', 'First spring app integrated with H2 DB', 'IDEA', 'ARTICLE', CURRENT_TIMESTAMP(),'sarthakkamble.io')