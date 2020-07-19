db.createUser({
	user: 'sa',
	pwd: 'db',
	roles: [{
		role: 'readWrite',
		db: 'productsdb'
	}]
});

