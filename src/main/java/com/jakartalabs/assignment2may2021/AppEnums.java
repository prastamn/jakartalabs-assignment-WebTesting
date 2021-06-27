package com.jakartalabs.assignment2may2021;

/**
 * Hello world!
 *
 */
public class AppEnums {

	public enum MenuNames {

		CHOOSEBASE("Choose a base"), ClOSEICON("closeButton"), NATASHAMSGPANEL("natashaMsgTopbar"),
		NATASHACLOSEPANEL("closePanel"), SIGNIN("Sign In"), PASSWORD("password");

		private String filter;

		private MenuNames(String filter) {
			this.filter = filter;
		}

		@Override
		public String toString() {
			return filter;

		}

	}

	public enum ButtonNames {

		PLANDELIVERY(" Plan Delivery "), DONE(" Done"), SAVE("Save "), STARTPROJECT("Start Project ");

		private String filter;

		private ButtonNames(String filter) {
			this.filter = filter;
		}

		@Override
		public String toString() {
			return filter;
		}

	}

	public enum TextBoxNames {

		BOOKING("eg. Booking.com");

		private String filter;

		private TextBoxNames(String filter) {
			this.filter = filter;
		}

		@Override
		public String toString() {
			return filter;
		}

	}

	public enum SpanNames {

		BUILDNOW("Build Now"), DASHBOARD("Dashboard");

		private String filter;

		private SpanNames(String filter) {
			this.filter = filter;
		}

		@Override
		public String toString() {
			return filter;

		}

	}

	public enum DivClassNames {

		PROFILE("userProfile");

		private String filter;

		private DivClassNames(String filter) {
			this.filter = filter;
		}

		@Override
		public String toString() {
			return filter;

		}

	}

	public enum NavigationCommands {

		BACK("Back"), FORWARD("Forward"), REFRESH("Refresh");

		private String filter;

		private NavigationCommands(String filter) {
			this.filter = filter;
		}

		@Override
		public String toString() {
			return filter;

		}

	}
}