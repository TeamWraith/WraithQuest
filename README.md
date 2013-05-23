WraithQuest
===========

A completely cross-platform quest logger primarily for Minecraft custom maps.

## FEATURES

* Cross-platform: Due to the program being built in Java for Minecraft, it will run on all platforms that may need it.
* Easily create quests: Writing a quest line is very simple, and with the possible release of a dev version, it will only become simpler.
* Support for cutscenes: If needed, the map developer can include links to YouTube cutscenes or conversations with each task.

## WRITING QUESTS

Currently, writing quests isn't very intuitive. In later builds, there will be more options for making this process easier.
For now, it follows this format:

	type=The type of quest. Currently the three types are "quest", "cutscene" and "character".
	state=The state of the quest. Currently the types are "disabled"(will make the quest unable to start), "not started", "started", "failed" and "completed".
	name=The name of the quest.
	description=The description for the quest on a single line. This is subject to change.For adding a new line, add <br>. For paragraphing, add <p>. Fot tabbing, add <t>

This is where all the task points will be written, in the following format.

	tasks={
		Link#Description of the task point; this is what will appear in the task list#Password#State
		2Link#New task point description#Password for this task#State for this task
	}

There can be an infinite amount of task points, all contained within the tasks block. The elements are separated by the hashtag (#).
Each task has its own link, description, password and state(determing what will show up in the logger and how it will look in the logger).
Keep in mind that the link is entirely optional, and if you only include three elements, they will be read like so:

	Description#Password#State

An example of a quest:

	type=quest
	state=started
	name=Collect 10 Bear Heads
	description=The farmer wants to make a bear head stew.<p>Collect ten bear heads for him.
	tasks={
	Collect 10 bear heads.#bear#started
	www.youtube.com/v?=EXAMPLE#Deliver them to the farmer.#pear#not started
	}

More examples can be found in the quests folder.

## CONTACT

Contact the developers of WraithQuest at
WraithTeam@gmail.com
