Project2

changing for pipeline test

Git instructions:

	Create (and switch to) new branch:
		git checkout -b (your branch name here)
	Change active branch:
		git checkout (branch name)
	
	Commands related to saving incremental changes you make locally:

		git status
			Check what files have been changed and what's staged for commit.
		git add (file name)
			Adds a specific file to staging (either a new one or one you've modified)
		git commit -m ""  
			Please be specific with commit comments
		git push
			This just updates your current branch with the changes you've made.

		
	
	WHEN IT COMES TO MERGING EVERYONE'S BRANCHES WITH MASTER:

		When someone is ready to merge what they've been working on with Master, they'll need to create a pull reaquest
		via the github UI. 
			- A pull request will then need to be reviewed, and any merge conflicts will need to be handled.
			- Once merge requests are handled, the master can be updated to include the code changed in your branch.

	"BUT PAUL, OTHER BRANCHES HAVE BEEN MERGED TO THE MASTER AND NOW WHAT I'M WORKING ON IS NOW OUT OF DATE!"

		Have no fear.
		From your branch you can use the command
				git fetch
		which will bring down the current copy of master to your branch (?).
		
		then you can use
				git rebase -i master
		to view a file that shows the changes which will be made. WHEN THIS FILE IS CLOSED THE CHANGES WILL TAKE PLACE.	


(I'm not sure about how some of this stuff works)   

