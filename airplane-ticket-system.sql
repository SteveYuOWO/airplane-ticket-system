DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user(
	[uid] CHAR(36) NOT NULL PRIMARY KEY,
	[username] VARCHAR(50) not null,
	[sex] BIT,
	[age] INT,
	[identity_num] VARCHAR(20),
	[level] INT,
	[score] INT,
	[address] VARCHAR(255),
	[mobile_num] VARCHAR(15),
	[password] CHAR(32) NOT NULL,
);
DROP TABLE IF EXISTS t_company;
CREATE TABLE t_company(
	ccid CHAR(36) NOT NULL PRIMARY KEY,
	[name] VARCHAR(50),
	[description] VARCHAR(255),
	[address] VARCHAR(255)
)

DROP TABLE IF EXISTS t_plane;
CREATE TABLE t_plane(
	ppid CHAR(36) NOT NULL PRIMARY KEY,
	[type] VARCHAR(50),
	seat_num INT,
	tourist_num INT,
	business_num INT,
	place VARCHAR(50),
	cid CHAR(36) FOREIGN KEY REFERENCES t_company(ccid)
)

DROP TABLE IF EXISTS t_airline;
CREATE TABLE t_airline(
	alid CHAR(36) NOT NULL PRIMARY KEY,
	startPlace VARCHAR(50),
	arrivePlace VARCHAR(50),
	ppid CHAR(36) FOREIGN KEY REFERENCES t_plane(ppid)
)

DROP TABLE IF EXISTS t_airflight;
CREATE TABLE t_airflight(
	afid CHAR(36) NOT NULL PRIMARY KEY,
	start_time DATETIME,
	arrive_time DATETIME,
	tourist_price DECIMAL(10,2),
	first_price DECIMAL(10,2),
	business_price DECIMAL(10,2),
	alid CHAR(36) FOREIGN KEY REFERENCES t_airline(alid)
)

DROP TABLE IF EXISTS t_ticket;
CREATE TABLE t_ticket(
	tid CHAR(36) NOT NULL PRIMARY KEY,
	purchase_time DATETIME,
	seat_num INT,
	[uid] CHAR(36) FOREIGN KEY REFERENCES t_user([uid]),
	afid CHAR(36) FOREIGN KEY REFERENCES t_airflight(afid),
);

