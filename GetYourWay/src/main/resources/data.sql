LOCK
TABLES `recommended_destination` WRITE;
/*!40000 ALTER TABLE `recommended_destination` DISABLE KEYS */;
INSERT INTO `recommended_destination`
VALUES (1, 'BFS',
        'Visit Belfast for its vibrant culture and explore the nearby coast and countryside to marvel at the spectacular locations from Game of Thrones.',
        'Belfast', 'Game of Thrones'),
       (2, 'NCE',
        'Start your own Riviera adventure from Nice. Dive into Azure seas and experience breathtaking clifftop drives.',
        'Nice', 'Riviera'),
       (3, 'SFO',
        'Step into an enviable lifestyle. Surf or simply relax on deserted beaches, See the spectacular Monterey Bay Aquarium and pause for coffee at Palace Trattoria - the real Blue Blues Cafe. Step into an enviable lifestyle. Surf or simply relax on deserted beaches, See the spectacular Monterey Bay Aquarium and pause for coffee at Palace Trattoria - the real Blue Blues Cafe. Step into an enviable lifestyle. Surf or simply relax on deserted beaches, See the spectacular Monterey Bay Aquarium and pause for coffee at Palace Trattoria - the real Blue Blues Cafe. ',
        'Monterey', 'Big Little Lies'),
       (4, 'JFK',
        'Choose to speed through the jostling attractions of Lower Manhattan (the 12th Precinct in Blue Bloods). Or opt for a more leisurely exploration of Brooklyn, where the Reagan clan gathers for Sunday dinners. ITs tranquil parks and cosy neighbourhood restaurants are the perfect balance to the buzz of downtown.\n',
        'New York', 'Blue Bloods'),
       (5, 'PRG',
        'George doesn’t have much time to enjoy the cityscapes and cafe culture in Prague in the Lazarus Project. Get lost in the winding lanes and characterful boutiques, explore the gothic castle and cross the famous Charles Bridge in the “City of a Hundred Spires”.',
        'Prague', 'The Lazarus Project'),
       (6, 'MAD',
        'Fly into the cosmopolitan capital Madrid and explore the iconic Prado Museum before heading west to explore the medieval hill towns of Careers, a UNESCO World Heritage Site, which you will recognise as King’s Landing and Trujillo.\n',
        'Caceres', 'House of the Dragon'),
       (7, 'ICN',
        'Zoom through Seoul on the subway, stopping off at palaces, parks and skyscrapers. Try the celebrated KFC - that’s Korean Fried Chicken - or delicious kimchi and bibimbap. Seoul has got something for everyone.',
        'Seoul', 'Money Heist Korea'),
       (8, 'YYZ',
        'Toronto stands in for New York in The Boys but it’s no second-choice as a holiday destination. See Niagara Falls from the water or take an aerial tour via a world-class winery. Stop off at the largest zoo in Canada and don’t forget to ascend the CN Tower to see Toronto from the top of the World.\n',
        'Toronto', 'The Boys'),
       (9, 'MLA',
        'In the movie, Malta\'s famous St. George\'s Square is overrun with dinosaurs, chasing actors Chris Pratt and Bryce Dallas Howard through the cobbled corners of Valletta, in one last battle between man and beast. We would recommend exploring at a more relaxed pace.\n',
        'Valletta', 'Jurassic World: Dominion'),
       (10, 'BOS',
        'The movie sees Ray Donovan return to his roots. Follow him to get a glimpse of New England’s capital. See Fenway Park, home of the Red Sox. Walk the Freedom Trail, which connects Boston’s historic monuments and sites. Ride America’s first subway, the T.',
        'Boston', 'Ray Donovan: The Movie');
/*!40000 ALTER TABLE `recommended_destination` ENABLE KEYS */;
UNLOCK
TABLES;
LOCK
TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users`
VALUES (1, 'Dan', 'McKeown', 'dannymac', 'dannyboy@fakemail.com', NULL, NULL, NULL),
       (2, 'Ann', 'Example', 'annnierose', 'annnierose@notreal.com', NULL, NULL, NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK
TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-28 22:16:33