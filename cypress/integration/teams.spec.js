/// <reference types="cypress" />

context('Teams', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8081/teams/all');
  })

  it('Teams lisitng page has cards', () => {
	cy.title().should('include', 'View team');
	cy.contains('Icehawks');
	cy.contains('Kemphanen');
  })

    it('Navbar is available', () => {
	cy.contains('Home');
	cy.contains('Roster');
	cy.contains('Analytics');
  })
})
