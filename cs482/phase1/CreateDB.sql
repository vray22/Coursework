create table Players (
			Name	varchar(64) not null,
            PlayerID	int ,
            TeamName	varchar(32),
            Position 	varchar(16) check(Position in('QB', 'RB', 'WR')),
            Touchdowns	int,
            TotalYards	int,
            Salary		int,
            primary key(PlayerID));
            
            
create table Games (
			GameID	int,
            Date	date,
            Stadium	varchar(256) not null,
            Result	varchar(16) check(Result in ('W', 'L', 'T')), 
            Attendance	int,
            TicketRevenue int,
            primary key(GameID));
            
create table Play (
			PlayerID int,
			GameID	int,
            primary key(PlayerID, GameID),
            foreign key(PlayerID) references Players(PlayerID),
            foreign key(GameID) references Games(GameID));
			